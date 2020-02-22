package com.gupaoedu.vip.pattern.template;

import com.gupaoedu.vip.pattern.template.dao.MemberDao;

/**
 * Created by Tom.
 */
public class MemberDaoTest {

    public static void main(String[] args) {

        MemberDao memberDao = new MemberDao(null);
        memberDao.query();
    }
}
