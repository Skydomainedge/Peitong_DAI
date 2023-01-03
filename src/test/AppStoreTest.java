
    <!DOCTYPE html>
    <html>
      <head>
        <meta charset="utf-8">
        <title> Tutors Reader </title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
      </head>
      <body>
        <script>
          var domain = window.location.hostname.substring(window.location.hostname.lastIndexOf(".", window.location.hostname.lastIndexOf(".") - 1) + 1);
          var url = window.location.href;
          var baseUrl = url.substring(url.indexOf('//') + 2);
          var array = baseUrl.split('/');
          array.pop();
          var tutorsUrl = array.join('/');
          window.location = "https://reader.tutors.dev" + "/#/course/" + tutorsUrl;
        </script>
      </body>
    </html>