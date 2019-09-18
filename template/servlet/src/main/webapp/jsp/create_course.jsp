<!DOCTYPE html>                                                                                                                                  
<html lang='en'>                                                                                                                                 
<head>                                                                                                                                         
<meta charset='utf-8'>                                                                                                                       
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<meta name='viewport' content='width=device-width, initial-scale=1'>                                                                         
<title>Seminar</title>                                                                      
<link rel='stylesheet' href='/css/bootstrap.min.css'>
</head>
<body>
<div class='container'>
    <div class='row'>                                                                                                     
        <div class='col-md-6 col-md-offset-3'>                                                                                                
            <h1 class='page-header text-center'>Create Course</h1>                                                                     
            <form class='form-horizontal' role='form' method='put' action='/course/create'>                                                       
                <div class='form-group'>                                                                                              
                    <label for='name' class='col-sm-2 control-label'>Name</label>                                                             
                    <div class='col-sm-10'>                                                                                                   
                        <input type='text' class='form-control' id='create_course_name' name='name' placeholder='Course Name'>           
                    </div>                                                                                                                    
                </div>                                                                                                                        
                <div class='form-group'>                                                                                                      
                    <label for='description' class='col-sm-2 control-label'>Description</label>                                                           
                    <div class='col-sm-10'>                                                                                               
                        <input type='text' class='form-control' id='create_course_description' name='description' placeholder='Course Description'>   
                    </div>                                                                                                                
                </div>
                <div class='form-group'>                                                                                                      
                    <label for='number' class='col-sm-2 control-label'>Number</label>                                                           
                    <div class='col-sm-10'>                                                
                        <input type='text' class='form-control' id='create_course_number' name='number' placeholder='23422'>   
                    </div>                                                                                                                  
                </div>
                <div class='form-group'>                                                                                                      
                    <label for='number' class='col-sm-2 control-label'>Location</label>                                                        
                    <div class='col-sm-10'>                                                
                        <input type='text' class='form-control' id='create_course_location' name='location' placeholder='Toronto'>   
                    </div>                                                                                                                  
                </div>                                                                               
                <div class='form-group'>                                                                                                      
                    <div class='col-sm-10 col-sm-offset-2'>                                                                                   
                        <input id='submit' name='submit' type='submit' value='Create' class='btn btn-primary'>                                  
                    </div>                                                                                                                    
                </div>                                                                                                                        
            </form>                                                                                                                           
        </div>                                                                                                                                
    </div>                                                                                                                             
</div>                                                                                                                                        
<script src='/js/jquery.min.js'></script>                                                                                                     
<script src='/js/bootstrap.min.js'></script>                                                                                                   
</body>