import 'package:flutter/material.dart';

import '../components/image_send_form.dart';
import '../utility/size.dart';

class ImageSendPage extends StatelessWidget {
  const ImageSendPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Padding(
      padding: const EdgeInsets.all(16.0),
      child: ListView(
        children: [
          const SizedBox(
            height: small_gap,
          ),
          ImageSendForm(),
        ],
      ),
    ));
  }
}
