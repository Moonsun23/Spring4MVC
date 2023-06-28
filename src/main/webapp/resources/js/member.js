/* join*/
let joinbtn = document.querySelector("#joinbtn");
joinbtn?.addEventListener('click', ()=> {
    let frm = document.forms.joinform;
    if (frm.userid.value === '') alert('아이디를 작성하세요!');
    else if (frm.passwd.value === '') alert('비밀번호를 작성하세요');
    else if (frm.repwd.value ==='') alert('비밀번호 재확인 해주세요');
    else if (frm.repwd.value !== frm.passwd.value) alert('비밀번호가 일치하지 않아요');
    else if (frm.name.value === '') alert('이름을 작성해주세요' );
    else if (frm.email.value === '') alert('이메일을 작성해주세요' );
    else {
        frm.method = 'post';
        frm.action = '/member/join';
        frm.submit();

    }

});

/* login*/

let loginbtn = document.querySelector("#loginbtn");
loginbtn?.addEventListener('click', ()=> {
   let frm = document.forms.loginform;
   if (frm.userid.value === '') alert('아이디를 입력하세요');
   else if(frm.passwd.value === '') alert('비밀번호를 입력하세요');
   else {
       frm.method = 'post';
       frm.action = '/member/login';
       frm.submit();
   }

// ?를 써주면 객체가 null 이더라도 그냥 넘어간다
});