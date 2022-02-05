package com.inossem.wms.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 对应actor_group表，字段group_typeint(11) NOT NULL经办岗位组 "0-公司默认经办岗位组， 1-个人自定义经办岗位组"
 * @author libin
 * 2019年3月2日
 */
public enum EnumActorGroupType {
	
	/** 公司默认经办岗位组 0 */
	CORPORATION_ACTOR_POST_GROUP(0), 
	/** 个人自定义经办岗位组 1 */
	PERSONAL_ACTOR_POST_GROUP(1), 
	;
	
	private static Map<Integer, String> map;

	public static Map<Integer, String> toMap() {
		if (map == null) {
			EnumActorGroupType[] ary = EnumActorGroupType.values();
			Map<Integer, String> enumMap = new HashMap<Integer, String>();
			for (EnumActorGroupType enumActorGroupType : ary) {
				enumMap.put(enumActorGroupType.getValue(), enumActorGroupType.name());
			}
			map = enumMap;
		}
		return map;
	}

	/** 枚举值 */
	private Integer value;

	private EnumActorGroupType(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public static String getEnumName(Integer value) {
		return toMap().get(value);
	}

}
