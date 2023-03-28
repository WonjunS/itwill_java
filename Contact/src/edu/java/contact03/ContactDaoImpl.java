package edu.java.contact03;

import edu.java.contact.model.Contact;

// MVC(Model-View-Controller) 아키텍쳐에서 컨트롤러 구현 클래스
// singleton 디자인 패턴을 적용

public class ContactDaoImpl implements ContactDao {
	
	// singleton
	private static ContactDaoImpl instance = null;
	
	private ContactDaoImpl() {};
	
	public static ContactDaoImpl getInstance() {
		if(instance == null) {
			instance = new ContactDaoImpl();
		}
		
		return instance;
	}
	
	// fields
	private static final int MAX_LENGTH = 2; // 배열의 길이(크기)
	private Contact[] contacts = new Contact[MAX_LENGTH]; // 연락처 객체들을 저장할 배열
	private int count = 0; // 배열의 현재까지 저장된 연락처 객체의 개수
	// -> 배열에 연락처를 저장할 때 +1, 배열에서 연락처 객체를 삭제할 때 -1
	
	// methods
	/**
	 * 연락처 배열에 새로운 연락처 객체를 저장할 수 있는지를 리턴
	 * @return 배열에 빈 공간이 있으면 true, 그렇지 않으면 false
	 */
	public boolean isMemoryAvailable() {
		return count < MAX_LENGTH;
	}
	
	/**
	 * 어떤 인덱스가 검색, 수정, 삭제할 때 사용 가능한 범위 안에 있는 인덱스인지를 리턴
	 * @param idx 유효한 인덱스인지 검사할 인덱스
	 * @return 사용가능한 인덱스는 true, 그렇지 않으면 false
	 */
	public boolean isValidIndex(int idx) {
		return (idx >= 0) && (idx < count);
	}

	// CRUD(Create, Read, Update, Delete) 기능 메서드들:
	@Override
	public int create(Contact c) {
		if(isMemoryAvailable()) { // 배열에 빈 공간이 있으면
			contacts[count++] = c;
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public Contact[] read() {
		Contact[] array = new Contact[count];
		// -> contacts 배열에 저장된 원소 개수만큼만 새로운 배열을 생성
		
		for(int i = 0; i < count; i++) {
			array[i] = contacts[i];
		}
		
		return array;
	}

	@Override
	public Contact read(int index) {
		if(isValidIndex(index)) {
			return contacts[index];
		} else {
			return null;
		}
	}

	@Override
	public int update(int index, Contact contact) {
		if(isValidIndex(index)) {
			contacts[index].setName(contact.getName());
			contacts[index].setPhone(contact.getPhone());
			contacts[index].setEmail(contact.getEmail());
			// contacts[index] = contact;
			
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int delete(int index) {
		if(isValidIndex(index)) {
			for(int i = index; i < count - 1; i++) {
				contacts[i] = contacts[i + 1];
			}
			contacts[count] = null;
			count--;
			return 1;
		} else {
			return 0;
		}
	}

}
