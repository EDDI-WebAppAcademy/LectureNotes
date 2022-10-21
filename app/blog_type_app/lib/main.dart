import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

import 'components/blog_type_list_item.dart';
import 'components/blog_type_menu.dart';
import 'components/blog_type_title.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: BlogTypePage(),
    );
  }
}

class BlogTypePage extends StatelessWidget {
  const BlogTypePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      appBar: _buildBlogTypeAppBar(),
      body: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 20.0),
        child: ListView(
          children: [
            BlogTypeTitle(),
            BlogTypeMenu(),
            BlogTypeListItem(imageName: 'avionic', title: 'test1-1'),
            BlogTypeListItem(imageName: "avionics2", title: "test2-1"),
            BlogTypeListItem(imageName: "raptor", title: "test3-1"),
          ],
        ),
      ),
    );
  }

  AppBar _buildBlogTypeAppBar () {
    return AppBar(
      backgroundColor: Colors.white,
      elevation: 1.0,
      actions: [
        Icon(
          CupertinoIcons.search,
          color: Colors.black,
        ),
        SizedBox(width: 15,),
        Icon(
          CupertinoIcons.antenna_radiowaves_left_right,
          color: Colors.green,
        ),
        SizedBox(width: 15,),
      ]
    );
  }
}
