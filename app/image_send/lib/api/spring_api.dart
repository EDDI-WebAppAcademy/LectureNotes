import 'dart:convert';
import 'dart:io';

import 'package:flutter/cupertino.dart';
import 'package:http/http.dart' as http;

import 'package:dio/dio.dart';
import 'package:file_picker/file_picker.dart';

class SpringApi {
  static const String httpUri =
      'http://192.168.219.102:7777/flutter-image/upload';

  Future<UserLoginResponse> login(UserLoginRequest request) async {
    List<File> imageFileList = <File>[];

    var request = http.MultipartRequest("POST", Uri.parse(httpUri));

    request.fields['parameter'] = "assets/images/mario1.jpg";
    request.fields['parameter2'] = "assets/images/mario2.jpg";

    for (var imageFile in imageFileList) {
      request.files.add(
          await http.MultipartFile.fromPath('imageFileList', imageFile.path));
    }

    debugPrint(request.fields['parameter']);
    debugPrint(request.fields['parameter2']);

    var response = await request.send();

    if (response.statusCode == 200) {
      debugPrint("통신 확인");
    }

    return UserLoginResponse(true);
  }

  Future<void> uploadFiles() async {
    // file picker를 통해 파일 여러개 선택
    FilePickerResult? result =
        await FilePicker.platform.pickFiles(allowMultiple: true);

    if (result != null) {
      final filePaths = result.paths;

      // 파일 경로를 통해 formData 생성
      var dio = Dio();
      var formData = FormData.fromMap({
        'files': List.generate(filePaths.length,
            (index) => MultipartFile.fromFileSync(filePaths[index]!))
      });

      // 업로드 요청
      final response = await dio.post(
          'http://192.168.219.102:7777/flutter-image/upload',
          data: formData);
    } else {
      // 아무런 파일도 선택되지 않음.
    }
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
