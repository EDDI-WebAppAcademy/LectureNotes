import 'package:flutter/cupertino.dart';

class BlogTypeListItem extends StatelessWidget {
  final String imageName;
  final String title;

  const BlogTypeListItem({
    Key? key,
    required this.imageName,
    required this.title
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 20),
      child: Column(
        children: [
          AspectRatio(
            aspectRatio: 2 / 1,
            child: ClipRRect(
              borderRadius: BorderRadius.circular(20),
              child: Image.asset("assets/images/$imageName.jpg", fit: BoxFit.cover),
            ),
          ),
          SizedBox(height: 10,),
          Text(
            title,
            style: TextStyle(fontSize: 20),
          )
        ],
      ),
    );
  }
}
