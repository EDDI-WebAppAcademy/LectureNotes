import 'package:flutter/material.dart';

import '../components/logo.dart';
import '../utility/size.dart';

class HomePage extends StatelessWidget {
  const HomePage({Key? key}) : super(key: key);

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
              TextButton(
                onPressed: () {
                  Navigator.pop(context);
                },
                child: const Text("서비스 시작!"),
              )
            ],
          ),
        )
    );
  }
}
