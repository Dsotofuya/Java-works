package edu.uptc.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import edu.uptc.entity.AccountStateType;

public class Test {
	public static void main(String[] args) {
//		List<AccountStateType> somethingList = new ArrayList<AccountStateType>(EnumSet.allOf(AccountStateType.class));
//		somethingList.remove(AccountStateType.CREADA);
//		for (AccountStateType accountStateType : somethingList) {
//			System.out.println(accountStateType.toString() + accountStateType.getRealStateTypeID());
//		}
//		System.out.println(AccountStateType.valueOf("CREADA"));
		System.out.println(Date.valueOf("2021-" + "03" + "-" + "03"));
	}
}
