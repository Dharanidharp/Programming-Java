function validate()
{

  var isQuizComplete = false;

  // Store hidden input thisScore

  // Username field input
  var userName = document.getElementsByName("UserInfo")[0].value;

  if(userName == null || userName == '')
  {
    alert("Your name cannot be empty");
    return false;
  }

    // Score
    var score = 0;
  
    var result = document.getElementsByName("thisScore")[0].value;
  
    //var allQAnswered = [false,false,false,false];
  
    // User inputs for the question 1
    var Q1 = document.getElementsByName("Q1")[0].value;
  
    // if q1 is null or empty
    if(Q1 == null || Q1 == '')
    {
      document.getElementById("Q1").style.backgroundColor = "yellow";
      alert("Question 1 is not answered");
      return false;
    }
  
    // User inputs for the question 2
    var Q2 = [document.getElementById("Q2a").checked,document.getElementById("Q2b").checked,document.getElementById("Q2c").checked,document.getElementById("Q2d").checked];
  
    // Store user choice into an array
    var checkedQ2 = new Array;
    for(var i = 0; i <= Q2.length; i++)
    {
      if(Q2[i] == true)
      {
        checkedQ2.push(Q2[i]);
      }
    }
  
    // if user choice is null
    if(checkedQ2.length === 0)
    {
      document.getElementById("Q2").style.backgroundColor = "yellow";
      alert("Question 2 is not answered");
      return false;
    }
    // if user choice is greater than 2
    else if(checkedQ2.length > 2)
    {
      document.getElementById("Q2").style.backgroundColor = "yellow";
      alert("You can only select two of the options for Question 2");
      return false;
    }
  
    // User inputs for the question 3
    var Q3 = document.getElementsByName("Q3");
    var checkedQ3 = new Array;
    
    // loop through all the options of q3
    for(var i = 0; i < Q3.length; i++)
    {
      // store the selected option in an array
      if(Q3[i].checked)
      {
        checkedQ3.push(Q3[i].value);
        break;
      }
    }
     
    // if user input is null
    if(checkedQ3.length === 0)
    {
      document.getElementById("Q3").style.backgroundColor = "yellow";
      alert("Question 3 is not answered");
      return false;
    }
  
    // User inputs for the question 4
    var Q4 = document.getElementsByName("Q4")[0].value;
  
    // if user input is null or empty
    if(Q4 == null || Q4 == '')
    {
      document.getElementById("Q4").style.backgroundColor = "yellow";
      alert("Question 4 is not answered");
      return false;
    }
  
    // Store actual answers
    var answer1 = "c";
    var answer2 = [document.getElementById("Q2a").checked,document.getElementById("Q2d").checked];
    var answer3 = "b";
    var answer4 = "british australian and new zealand";
  
  
    // Check the user answers with correct answers
    if(Q1 == answer1)
    {
      score++;    
    }
  
    if(checkedQ2[0] == answer2[0] && checkedQ2[1] == answer2[1])
    {
      score+=2;
    }
  
    if(checkedQ3 == answer3)
    {
      score++;
    }
  
    if(Q4 == answer4)
    {
      score++;
    }
  
    result = score;
    alert("Your score is " + result);
}