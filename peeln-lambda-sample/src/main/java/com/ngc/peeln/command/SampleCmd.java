package com.ngc.peeln.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.ngc.peeln.es.SampleService;

@Component
public class SampleCmd {

    @Autowired
    private SampleService sampleService;
//    private SampleService service = new SampleServiceImpl();

    public void setValues(SampleBean bean) {
        
//        service.findByFirstName("hoge");

        bean.setStr1("1");
        bean.setStr2("2");
        bean.setStr3("3");
        bean.setList(Lists.newArrayList());
        bean.getList().add("a");
        bean.getList().add("b");
        bean.getList().add("c");
        bean.getList().add("d");

    }

    public String test() {
        return sampleService.test();
    }

}
