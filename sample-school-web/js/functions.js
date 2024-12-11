function displayCourseList() {
    fetch('http://localhost:8080/courses')
    .then(response=>response.json())
    .then(data=>printCourses(data))
    .catch(e=>console.log(e));

}

function printCourses(courses){
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
function displayInstructors() {
    fetch('http://localhost:8080/instructors')
    .then(res => res.json())
    .then(data=>printInstructors(data));  
}  

function printInstructors(list){
    var text = "";
    for (instructor of list) {
        text += instructor.id+" ";
        text += instructor.name;
        text += "<br>"

    }
    document.getElementById("instructors").innerHTML = text;
}

function createNewCourse(){
 var courseCode=document.getElementById("courseCode").value;
 var courseName=document.getElementById("courseName").value;
 var credit=document.getElementById("credit").value;
 var roomNumber=document.getElementById("room").value;
 var course={
        "name": courseName,
        "code": courseCode,
        "credit": credit,
        "officeNumber": roomNumber
 }

 var options ={
    method: 'POST',
     body: JSON.stringify(course),
        headers: new Headers({
        'Content-Type': 'application/json'
        })
    }
        

 fetch('http://localhost:8080/courses',options)
 .then(()=>alert("course saved successfully"));
return false;
}
