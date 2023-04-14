package edu.java.contact05;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import edu.java.contact.fileutil.FileUtil;
import edu.java.contact.model.Contact;

// MVC(Model-View-Controller) 아키텍쳐에서 컨트롤러 구현 클래스
// singleton 디자인 패턴을 적용

public class ContactDaoImpl implements ContactDao {
	
	// singleton
	private static ContactDaoImpl instance = null;
	
	private ContactDaoImpl() {
		dataDir = FileUtil.initDataDir();
		dataFile = new File(FileUtil.DATA_DIR, FileUtil.DATA_FILE);
		contacts = FileUtil.initData();
	};
	// TODO: ContactDaoImpl에는 연락처 데이터를 변경하는 메서드들이 있음
	// -> 연락처 데이터가 변경되는 메서드에서 FileUtil.writeDataToFile() 메서드 호출
	
	public static ContactDaoImpl getInstance() {
		if(instance == null) {
			instance = new ContactDaoImpl();
		}
		
		return instance;
	}
	
	// fields
	private List<Contact> contacts;
	private File dataDir; // 연락처 데이터 파일을 저장할 폴더
	private File dataFile; // 연락처 데이터 파일
	
	// methods	
	/**
	 * 어떤 인덱스가 검색, 수정, 삭제할 때 사용 가능한 범위 안에 있는 인덱스인지를 리턴
	 * @param idx 유효한 인덱스인지 검사할 인덱스
	 * @return 사용가능한 인덱스는 true, 그렇지 않으면 false
	 */
	public boolean isValidIndex(int idx) {
		return (idx >= 0) && (idx < contacts.size());
	}

	// CRUD(Create, Read, Update, Delete) 기능 메서드들:
	@Override
	public int create(Contact c) {
		contacts.add(c);
		FileUtil.writeDataToFile(contacts, dataFile);
		return 1;
	}

	@Override
	public List<Contact> read() {
		return contacts;
	}

	@Override
	public Contact read(int index) {		
		try {
			List<Contact> list = FileUtil.readDataFromFile(dataFile);
			return list.get(index);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int update(int index, Contact contact) {
		if(isValidIndex(index)) {
			contacts.get(index).setName(contact.getName());
			contacts.get(index).setPhone(contact.getPhone());
			contacts.get(index).setEmail(contact.getEmail());
			FileUtil.writeDataToFile(contacts, dataFile);
			return 1;
		}
		return 0;
	}

	@Override
	public int delete(int index) {
		if(!isValidIndex(index)) {
			return 0;
		}
		
		contacts.remove(index);
		FileUtil.writeDataToFile(contacts, dataFile);
		
		return 1;
	}

}
