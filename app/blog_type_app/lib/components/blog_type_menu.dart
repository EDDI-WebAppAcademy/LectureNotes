import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class BlogTypeMenu extends StatelessWidget {
  const BlogTypeMenu({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.only(top: 20),
      child: Row(
        children: [
          _buildMenuItem(Icons.electric_car_outlined, "EV Charging"),
          SizedBox(width: 5,),
          _buildMenuItem(Icons.highlight_outlined, "LED Dimming"),
          SizedBox(width: 5,),
          _buildMenuItem(Icons.camera_alt_outlined, "Camera Streaming"),
        ],
      ),
    );
  }

  Widget _buildMenuItem(IconData mIcon, String text) {
    return Container(
      width: 90,
      height: 72,
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(30),
        border: Border.all(color: Colors.black12),
      ),
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Icon(mIcon, color: Colors.blueAccent, size: 30),
          SizedBox(height: 5,),
          Text(
            text, style: TextStyle(fontSize: 9, color: Colors.black87),
          )
        ],
      ),
    );
  }
}
