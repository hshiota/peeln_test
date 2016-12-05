package com.ngc.peeln;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.ngc.peeln.command.SampleBean;
import com.ngc.peeln.command.SampleCmd;

import lombok.Setter;

@SpringBootApplication
public class LambdaFunctionHandler implements RequestHandler<Object, Object> {

    @Autowired
    private SampleBean sampleBean;
    // private SampleBean sampleBean = new SampleBean();

    @Autowired
    private SampleCmd sampleCmd;
    // private SampleCmd sampleCmd = new SampleCmd();

    @Setter
    private Object input;

    @Setter
    private Context context;

    @Setter
    private String args[];

    @Override
    public Object handleRequest(Object input, Context context) {

        setArgs(new String[0]);
        
        try (ConfigurableApplicationContext ctx = SpringApplication.run(LambdaFunctionHandler.class, args)) {
            context.getLogger().log(">>>>>A");
            LambdaFunctionHandler app = ctx.getBean(LambdaFunctionHandler.class);
            context.getLogger().log(">>>>>B");
            app.setInput(input);
            context.getLogger().log(">>>>>C");
            app.setContext(context);
            context.getLogger().log(">>>>>D");
            app.run("");
            return "success.";

        } catch (Exception e) {
            e.printStackTrace();
            context.getLogger().log("error.\n");
            return e.getMessage();
        }
    }

    public void run(String... args) throws Exception {

        // ここでは細かいロジックは書かないこと
        // 自端末とサーバをつなぐターミナルエミュレータのようにコマンドを実行するイメージでコマンドパターンクラスを実行すること
        sampleCmd.setValues(sampleBean);
        context.getLogger().log(sampleCmd.test());

    }

}