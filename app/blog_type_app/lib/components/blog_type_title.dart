import 'package:flutter/cupertino.dart';

class BlogTypeTitle extends StatelessWidget {
  const BlogTypeTitle({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.only(top: 20),
      child: Text(
        "EDDI Robot Academy",
        style: TextStyle(fontSize: 25),
      )
    );
  }
}
