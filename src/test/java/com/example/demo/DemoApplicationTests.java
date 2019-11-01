package com.example.demo;

import com.example.demo.model.AyUser;
import com.example.demo.service.AyUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Resource
	private JdbcTemplate jdbcTemplate;

	/**
	 * Mysql集成Spring Boot简单测试
	 */
	@Test
	public void mySqlTest() {
		String sql = "select id,name,password from ay_user";
		List<AyUser> userList =
				(List<AyUser>) jdbcTemplate.query(sql, new RowMapper<AyUser>() {
					@Override
					public AyUser mapRow(ResultSet rs, int rowNum) throws SQLException {
						AyUser user = new AyUser();
						user.setId(rs.getLong("id"));
						user.setName(rs.getString("name"));
						user.setPassword(rs.getString("password"));
						return user;
					}
				});
		System.out.println("查询成功：");
		for (AyUser user : userList) {
			System.out.println("【id】: " + user.getId() + "；【name】: " + user.getName());
		}
	}

	@Resource
	private AyUserService ayUserService;

	@Test
	public void testRepository() {
//		查询所有数据
		List<AyUser> userList = ayUserService.findAll();
		System.out.println("findAll():" +userList.size());

////		通过name查询数据
		List<AyUser> userList2 = ayUserService.findByName("Amy");
		System.out.println("findByName():" + userList2.size());
		Assert.isTrue(userList2.get(0).getName().equals("Amy"), "data error");

//		通过name模糊查询
		List<AyUser> userList3 = ayUserService.findByNameLike("%Lily%");
		System.out.println("findByNameLike(): "+ userList3.size());
		Assert.isTrue(userList3.get(0).getName().equals("Lily"), "data error");

//			通过id查询
		List<Long> ids = new ArrayList<Long>();
		ids.add((long) 1);
		ids.add((long) 2);
		List<AyUser> userList4 = ayUserService.findByIdIn(ids);
		System.out.println("findByIdIn():" + userList4.size());

//	分页查询数据
		PageRequest pageRequest =  PageRequest.of(0,10);
		Page<AyUser> userlist5 = ayUserService.findAll(pageRequest);
		System.out.println("page findAll():" + userlist5.getTotalPages()+ "/" + userlist5.getSize());

//		新增数据

		AyUser ayUser = new AyUser();
		ayUser.setId((long) 3);
		ayUser.setName("小小");
		ayUser.setPassword("1234");
		ayUserService.save(ayUser);

//		删除数据
		ayUserService.delete((long)3);
	}

	@Test
	public void testTransaction() {
		AyUser ayUser = new AyUser();
		ayUser.setId((long) 7);
		ayUser.setName("啊2");
		ayUser.setPassword("123456777");
		ayUserService.save(ayUser);

	}



}
