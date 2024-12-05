function displayCourseList() {
    var courses = [
        {
            "name": "OO programming with Java",
            "code": "CS105",
            "credit": 6,
            "officeNumber": null
        },
        {
            "name": "Frontend Applications",
            "code": "CS391",
            "credit": 4,
            "officeNumber": null
        },
        {
            "name": "Backend Applications",
            "code": "CS393",
            "credit": 4,
            "officeNumber": null
        },
        {
            "name": "OO programming with Java",
            "code": "CS106",
            "credit": 6,
            "officeNumber": null
        },
        {
            "name": "Data Structures",
            "code": "CS201",
            "credit": 6,
            "officeNumber": "231"
        },
        {
            "name": "Introduction to programming",
            "code": "CS101",
            "credit": 6,
            "officeNumber": "401"
        },
        {
            "name": "Introduction to programming",
            "code": "CS101",
            "credit": 6,
            "officeNumber": "401"
        },
        {
            "name": "amnsabdvsab sadnbamnsda",
            "code": "CS111",
            "credit": 6,
            "officeNumber": "242"
        }
    ];

    var table = "<table>";
    for (i = 0; i < courses.length; i++) {
        table += "<tr>"
        table += "<td>" + courses[i].name + "</td><td> " +
            courses[i].code + "</td><td> " +
            courses[i].credit + "</td><td>" +
            courses[i].officeNumber + "</td><td> ";
        table += "</tr>"
    }
    table += "</table>";




    document.getElementById("courses").innerHTML = table;
}

 var list=[
    {
      "name": "Hasan",
      "id": 52
    },
    {
      "name": "Fatih",
      "id": 53
    }
  ];
  

    var text = "";
    for (instructor of list) {
        text+=instructor.name ;
        text+="<br>"
        
    }
    document.getElementById("instructors").innerHTML = text;
}  
