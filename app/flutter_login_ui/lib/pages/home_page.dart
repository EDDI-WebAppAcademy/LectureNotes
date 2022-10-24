import 'package:flutter/material.dart';

import '../components/logo.dart';
import '../size.dart';

class HomePage extends StatelessWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Padding(
          padding: const EdgeInsets.all(16.0),
          child: ListView(
            children: [
              SizedBox(height: small_gap,),
              Logo(title: "Login",),
              SizedBox(height: small_gap,),
              TextButton(
                onPressed: () {
                  Navigator.pop(context);
                },
                child: Text("서비스 시작!"),
              )
            ],
          ),
        )
    );
  }
}
