package com.chitransh.jpaApp;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chitransh.jpaApp.config.JpaConfiguration;

@ContextConfiguration(classes={JpaConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class ParentTest {

}
