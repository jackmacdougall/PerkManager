document.addEventListener('DOMContentLoaded', function() {
    document.getElementById("sign-up-btn").addEventListener("click", function(){
        document.getElementById("sign-up-btn").disabled = true;
        document.getElementsByTagName('fieldset')[0].disabled = true;
        document.getElementById("create-profile-panel").style.visibility = "visible";
    });
    document.getElementById("create-profile-btn").addEventListener("click", function(){
        let username = document.getElementById("new-username-input").value;
        let password = document.getElementById("new-password-input").value;
        let confirm = document.getElementById("confirm-password-input").value;
        if (password.localeCompare(confirm) == 0){
            let profileData = {};
            profileData["username"] = username;
            profileData["password"] = password;
            profileData["role"] = "user";
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "profile/add",
                data: JSON.stringify(profileData),
                dataType: 'json',
                success: function(data) {
                    document.getElementById("new-username-input").disabled = true;
                }
            });
        }
    });
    document.getElementById("login-btn").addEventListener("click", function() {
        let username = document.getElementById("username-input").value;
        let password = document.getElementById("password-input").value;
        $.ajax({
            type: "GET",
            url: "profile/login",
            contentType: "application/json",
            dataType: 'json',
            data: {"username" : username, "password" : password},
            success: function(response) {
                window.location = '/main';
            },
            error: function(e) {
                alert(e);
            }
        });
    });
});