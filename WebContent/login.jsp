<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Sign In</title>
        <link rel="stylesheet" href="Style.css">
            </head> 
            <body class="BackGround"> 
         <div>
            <h2 class="sign">User Login</h2>
            
            <form action ="LoginController" method="post">
            
                    <h2 class="inputbox">UserId 
                    <input  type="text" name="Userid" placeholder="UserId" style="margin-left:4%">
                         <br>   Password 
                    <input  type="password" name ="Password" placeholder="Password"> <br>
                          </h2>
                    <button type="submit" class="buttonbox" value="Log in" style="margin-left: 50%" >Log in</button> 
                  
                  <% if(session.getAttribute("login_msg")!=null){  %>
                	<script>alert("Incorrect user name or password")</script>
                	<% 
                		session.removeAttribute("login_msg");  
                  }%>
                  
                  
               </form>
               </div>
            </body>
</html>