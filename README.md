[![](https://static.thenounproject.com/png/605579-200.png)]()
[![](http://freevector.co/wp-content/uploads/2009/06/36738-right-arrow-200x200.png)]()
[![](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRRS0y-lTeGRr-U-DufdcwIYTt_vxb-Kqv-ERVTnfF9xMS01EP7)]()

## CSV to JSON Converter
> by Richard Arredondo

- Description

The purpose of this program was to convert a CSV file into a JSON file for the intensions of using as specified. The CSV data is 
interpreted by programs such as Excel. It is represented as tabular data in the form of lists seperated by commas making it easier to 
read by us users. The reason to convert it to a JSON file is due to the way computers store information. JSON data is a JavaScripted 
notation to be able to store data in a structures form.

[![](http://www.computing.outwood.com/NEA/python/images/writing7.png)]()

- CSV 
   - Comma Seperated Values are created when data is pulled from or pushed to a speadsheet. This makes it easy
     for the user to read. Also it makes it easy for the computer to be able to split the data up into parts. 
      - CSV data EX:  "ID","Total","Assignment 1","Assignment 2","Exam 1"
                      "111278","611","146","128","337"
                      "111352","867","227","228","412"
                      "111373","461","96","90","275"
                      "111305","835","220","217","398"
                      "111399","898","226","229","443"
                      "111160","454","77","125","252"
                      "111276","579","130","111","338"
                      "111241","973","236","237","500"
  
  [![](https://img.viralpatel.net/2016/06/spring-4-mvc-rest-get-example.png)]()
  
 - JSON 
   - JavaScript Object Notation is used when transfering javascript data through an HTML document. The universal format for
    computers today use JSON formating. It's also widely known to developers.
      - JSON data EX: {"rowHeaders":["111278","111352","111373","111305","111399","111160","111276","111241"],"data":[[611,146,128,337],
        [867,227,228,412],[461,96,90,275],[835,220,217,398],[898,226,229,443],[454,77,125,252],[579,130,111,338],[973,236,237,500]],
        "colHeaders":["ID","Total","Assignment 1","Assignment 2","Exam 1"]}
    
 - Method
   - CSV being represented as tabular data used to import or exort data to and from databases, used in spreadsheets, and used to copy
    and paste data to and from any desktops OS; tend to overlape with the fact that JSON files are used in program API's and configuration
    files. So the reason for needing a converter is so that when a CSV file is turned into an array of arrays as a JSON it makes it hard
    to interpret for the user. Since the array of arrays create a back to back system of bracets and no newline characters, the readability
    is far to hard to understand the insides of the information.
