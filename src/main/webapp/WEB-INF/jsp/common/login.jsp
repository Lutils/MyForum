<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 弹出对话框 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">登录/注册</h4>
      </div>
      <div class="modal-body">
        <input type="text" id="username" maxlength="20"  class="form-control" placeholder="用户名"><br>
        <input type="password" id="password" maxlength="20"  class="form-control" placeholder="密码">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" onclick="regist()">注册</button>
        <button type="button" class="btn btn-primary" onclick="login()">登录</button>
      </div>
    </div>
  </div>
</div>