package com.lucasdsf.api.auth.enums;

import java.util.stream.Stream;

public enum ProfileEnums {
	ROLE_MASTER(1),
	ROLE_ADMIN(2),
	ROLE_USER(3);
	
	private Integer id;

	private ProfileEnums(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
    public static String[] getNames() {
    	String[] names = new String[values().length];
    	for(int index = 0; index < values().length; index++) {
    		names[index] = values()[index].name();
    	}
    	
    	return names;
    }
    
    public static ProfileEnums findById(Integer id) {
		return Stream.of(ProfileEnums.values())
			.filter(valueId -> valueId.equals(id))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(String.format("Perfil %s não localizado.",id)));
	}
}
