%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quiz Result</title>
</head>
<body>
    <h1>Quiz Result</h1>
    <% 
        // Get user's answer and correct answer
        int userAnswer = Integer.parseInt(request.getParameter("answer"));
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        int correctAnswer = num1 + num2;

        // Check if the answer is correct
        boolean isCorrect = userAnswer == correctAnswer;
    %>
    <p>Your answer: <%= userAnswer %></p>
    <p>Correct answer: <%= correctAnswer %></p>
    <% 
        if (isCorrect) { 
    %>
            <p style="color:green;">Correct!</p>
    <% 
        } else { 
    %>
            <p style="color:red;">Incorrect!</p>
    <% 
        } 
    %>
</body>
</html>