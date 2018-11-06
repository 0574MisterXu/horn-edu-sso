package com.horn.edu.sso.server.controller.admin;

import com.horn.edu.sso.server.controller.common.BaseController;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by misterxu on 2018/11/6.
 */
@Api(tags = "应用管理")
@Controller
@RequestMapping("/admin/app")
public class AppController  extends BaseController {
}
