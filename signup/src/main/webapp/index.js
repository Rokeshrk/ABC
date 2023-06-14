function Check(){
        let input = document.querySelector('.searchbar').value.toLowerCase();
        let uname=document.querySelectorAll('.uname');
		let rollno=document.querySelectorAll('.rollno');
		let email=document.querySelectorAll('.email');
		let pswd=document.querySelectorAll('.pswd');
		let tot=uname.length;


		
	    for (let i = 0; i < tot; i++) {
            if(uname[i].innerHTML.toLowerCase().includes(input) || rollno[i].innerHTML.toLowerCase().includes(input) || email[i].innerHTML.toLowerCase().includes(input) || pswd[i].innerHTML.toLowerCase().includes(input) ){
				uname[i].parentNode.style.display=""
				rollno[i].parentNode.style.display=""
				email[i].parentNode.style.display=""
				pswd[i].parentNode.style.display=""	
			}
            else{
                uname[i].parentNode.style.display="none"
			}
	    }
	   }