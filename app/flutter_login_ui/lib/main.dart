import 'package:flutter/material.dart';
import 'package:flutter_login_ui/pages/home_page.dart';
import 'package:flutter_login_ui/pages/login_page.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(
        textButtonTheme: TextButtonThemeData(
          style: TextButton.styleFrom(
            backgroundColor: Colors.black,
            primary: Colors.white,
            shape:
              RoundedRectangleBorder(borderRadius: BorderRadius.circular(30)),
            minimumSize: Size(300, 45),
          )
        )
      ),
      title: 'Flutter Demo',
      initialRoute: "/login",
      routes: {
        "/login": (context) => LoginPage(),
        "/home": (context) => HomePage(),
      },
    );
  }
}