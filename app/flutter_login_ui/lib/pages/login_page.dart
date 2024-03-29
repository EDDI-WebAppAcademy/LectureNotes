import 'package:flutter/material.dart';
import 'package:flutter_login_ui/components/custom_form.dart';
import 'package:flutter_login_ui/utility/size.dart';

import '../components/logo.dart';

class LoginPage extends StatelessWidget {
  const LoginPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: ListView(
          children: [
            const SizedBox(height: small_gap,),
            const Logo(title: "Login",),
            const SizedBox(height: small_gap,),
            CustomForm(),
          ],
        ),
      )
    );
  }
}
