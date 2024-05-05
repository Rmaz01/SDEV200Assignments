import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class M07ProgrammingAssignment1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
        double annualInterestRate = Double.parseDouble(request.getParameter("annualInterestRate"));
        int numberOfYears = Integer.parseInt(request.getParameter("numberOfYears"));

        // Create Loan object
        Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);

        // Calculate monthly and total payments
        double monthlyPayment = loan.getMonthlyPayment();
        double totalPayment = loan.getTotalPayment();

        // Display results
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Loan Calculation Result</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Loan Calculation Result</h2>");
        out.println("<p>Monthly Payment: " + monthlyPayment + "</p>");
        out.println("<p>Total Payment: " + totalPayment + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}