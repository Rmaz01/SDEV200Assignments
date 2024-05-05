<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Addition Quiz</title>
</head>
<body>
    <h1>Addition Quiz</h1>
    <form method="post" action="quizResult.jsp">
        <% 
            // Generate random numbers for the quiz
            int num1 = (int)(Math.random() * 100);
            int num2 = (int)(Math.random() * 100);
        %>
        <p>What is <%= num1 %> + <%= num2 %>?</p>
        <input type="hidden" name="num1" value="<%= num1 %>">
        <input type="hidden" name="num2" value="<%= num2 %>">
        <input type="text" name="answer" required>
        <br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>