document.addEventListener('DOMContentLoaded', function() {
    let username = document.getElementById("username").innerHTML;
	document.getElementById("add-membership-btn").addEventListener('click', function() {
	    document.getElementById("membership-forms").style.visibility = "visible";
	    $.ajax({
	        type: "GET",
	        url: "/api/membership/user?username=" + username,
	        dataType: "json",
            success: function (data) {
                let options = '<option value="1">Select a membership</option>';
                for (let i = 0; i < data.length; i++) {
                    options += '<option value="' + data[i].id + '">' + data[i].name + '</option>';
                }
                $("#memberships-dropdown").html(options);
            }
	    });
	});
	document.getElementById("membership-dropdown-btn").addEventListener('click', function() {
	    if (document.getElementById("memberships-dropdown").selectedIndex != "0") {
	        var user, membership;
            var membershipName = document.getElementById("memberships-dropdown").options[document.getElementById("memberships-dropdown").selectedIndex].text;
            $.ajax({
                type: "GET",
                url: "/api/user/username?username=" + username,
                success: function (result) {
                    user = result;
                    $.ajax({
                        type: "GET",
                        url: "/api/membership/name?name=" + membershipName,
                        success: function (result) {
                            membership = result;
                            let postData = {
                                userObj: user,
                                membershipObj: membership
                            };
                            $.ajax({
                                type: "POST",
                                url: "/api/user/membership",
                                contentType : "application/json",
                                cache: false,
                                async: false,
                                data: JSON.stringify(postData),
                                success: function () {
                                    document.getElementById("membership-forms").style.visibility = "hidden";
                                }
                            });
                        }
                    });
                }
            });
        }
	});
	document.getElementById("new-membership-btn").addEventListener('click', function() {
	    var user;
	    var membershipName = document.getElementById("new-membership-txt").value;
	    $.ajax({
            type: "GET",
            url: "/api/user/username?username=" + username,
            success: function (result) {
                user = result;
                let postData = {
                    userObj: user,
                    membershipName: membershipName
                };
                $.ajax({
                    type: "POST",
                    url: "/api/user/membership/new",
                    contentType : "application/json",
                    cache: false,
                    async: false,
                    data: JSON.stringify(postData),
                    success: function () {
                        document.getElementById("membership-forms").style.visibility = "hidden";
                    }
                });
            }
        });
	});
});