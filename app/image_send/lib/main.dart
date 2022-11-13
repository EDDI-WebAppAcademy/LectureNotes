import 'package:flutter/material.dart';
import 'package:image_send/page/image_send_page.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(
          textButtonTheme: TextButtonThemeData(
              style: TextButton.styleFrom(
        backgroundColor: Colors.black,
        primary: Colors.white,
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(30)),
        minimumSize: Size(300, 45),
      ))),
      title: 'Flutter Demo',
      initialRoute: "/home",
      routes: {
        "/home": (context) => ImageSendPage(),
      },
    );
  }
}
