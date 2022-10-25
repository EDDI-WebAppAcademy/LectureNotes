import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_login_ui/components/text_form_field.dart';
import 'package:flutter_login_ui/utility/size.dart';

import '../api/spring_api.dart';

class CustomForm extends StatelessWidget {
  final _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    return Form(
        key: _formKey,
        child: Column(
          children: [
            const CustomTextFormField(text: "이메일"),
            const SizedBox(height: small_gap,),
            const CustomTextFormField(text: "비밀번호"),
            const SizedBox(height: medium_gap,),
            TextButton(
              onPressed: () {
                SpringApi().login(UserLoginRequest("test@gmail.com", "456123"));

                if (_formKey.currentState!.validate()) {
                  Navigator.pushNamed(context, "/home");
                }
              },
              child: const Text("로그인"),
            )
          ],
        )
    );
  }
}
