import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);
  
  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      home: TestPage(),
    );
  }
}

class TestPage extends StatelessWidget {
  const TestPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Column(
          children: [
            Padding(
                padding: const EdgeInsets.all(25.0),
                child: Row(
                  children: const [
                    Text("C", style: TextStyle(fontWeight: FontWeight.bold)),
                    Spacer(),
                    Text("Java", style: TextStyle(fontWeight: FontWeight.bold)),
                    Spacer(),
                    Text("Rust", style: TextStyle(fontWeight: FontWeight.bold)),
                    Spacer(),
                    Text("Golang", style: TextStyle(fontWeight: FontWeight.bold)),
                  ],
                )
            ),
            Expanded(
              child: SizedBox(
                  width: double.infinity,
                  height: double.infinity,
                  child: Image.asset("assets/avionic.jpg", fit: BoxFit.cover)),
            ),
            const SizedBox(height: 5,),
            Expanded(
              child: Image.asset("assets/avionics2.jpg", fit: BoxFit.fill),
            ),
          ],
        )
      )
    );
  }
}

