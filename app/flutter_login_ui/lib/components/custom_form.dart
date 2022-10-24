import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_login_ui/components/text_form_field.dart';
import 'package:flutter_login_ui/size.dart';

class CustomForm extends StatelessWidget {
  final _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    return Form(
        key: _formKey,
        child: Column(
          children: [
            CustomTextFormField(text: "이메일"),
            SizedBox(height: small_gap,),
            CustomTextFormField(text: "비밀번호"),
            SizedBox(height: medium_gap,),
            TextButton(
              onPressed: () {
                if (_formKey.currentState!.validate()) {
                  Navigator.pushNamed(context, "/home");
                }
              },
              child: Text("로그인"),
            )
          ],
        )
    );
  }
}
