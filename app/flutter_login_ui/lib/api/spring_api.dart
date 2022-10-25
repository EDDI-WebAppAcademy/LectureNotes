import 'dart:convert';

import 'package:flutter/cupertino.dart';
import 'package:http/http.dart' as http;

class SpringApi {
  static const String httpUri = '192.168.30.187:7777';

  Future<UserLoginResponse> login (UserLoginRequest request) async {
    var data = { 'email': request.email, 'password': request.password };
    var body = json.encode(data);

    debugPrint(request.email);
    debugPrint(request.password);
    debugPrint(body);

    var response = await http.post(
      //Uri.http(httpUri, '/flutter-test/login'),
      Uri.http(httpUri, '/58th/member/sign-in'),
      headers: {"Content-Type": "application/json"},
      body: body,
    );

    if (response.statusCode == 200) {
      debugPrint("통신 확인");
    }

    return UserLoginResponse(true);
  }
}

class UserLoginResponse {
  bool? success;

  UserLoginResponse(this.success);
}

class UserLoginRequest {
  String email;
  String password;

  UserLoginRequest(this.email, this.password);
}