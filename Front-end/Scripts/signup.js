let submitbtn= document.querySelector(".form>form");






const url= "http://localhost:8088/VegStore/customerRegister";
submitbtn.onsubmit=(e)=>{
     e.preventDefault();
   
    let name= document.querySelector("#name").value;
    let username= document.querySelector("#username").value;
    let email= document.querySelector("#email").value;
    let phone= document.querySelector("#phone").value;
    let password= document.querySelector("#password").value;
    
    
    
    
    let ob= {
           "userName":username,
           "email":email,
           "password":password,
           "phone":phone,
           "role":"Customer",
           "name":name,
          
            
    }

    signupdata(url,ob);  
    console.log("working");
    document.querySelector("#submit-btn").disabled=true;
    document.querySelector("#name").value="";
    document.querySelector("#username").value="";
    document.querySelector("#email").value="";
    document.querySelector("#phone").value="";
   
     document.querySelector("#password").value="";
    //  window.location.href="login.html";
    
   

};




let signupdata= async (url,ob)=>{
    try {
         let res = await fetch(url,{
            method:"POST",
            headers:{
                "Content-Type":"application/json"
            },
            body:JSON.stringify(ob)
         });
          
         if(res.ok)
        {
         let ans= await res.json();
         localStorage.setItem("customer",JSON.stringify(ans));
         localStorage.setItem("loggedsession",JSON.stringify(false));
         alert("Registration successful welcome"+ans.name);

        }
        else
        {
        let error= await res.json();
         console.log(error);
         
        
         alert("Something Went wrong");
        }
    } catch (error) {
        alert(error);
    }
};