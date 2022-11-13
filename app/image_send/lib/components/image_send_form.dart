import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

import '../api/spring_api.dart';

class ImageSendForm extends StatelessWidget {
  final _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    return Form(
        key: _formKey,
        child: Column(
          children: [
            TextButton(
              onPressed: () {
                SpringApi().uploadFiles();

                if (_formKey.currentState!.validate()) {
                  Navigator.pushNamed(context, "/home");
                }
              },
              child: const Text("이미지 전송!"),
            )
          ],
        ));
  }
}
