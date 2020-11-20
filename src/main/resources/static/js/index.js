document.addEventListener('DOMContentLoaded', function() {
    let username = document.getElementById("username").innerHTML;
	document.getElementById("add-membership-btn").addEventListener('click', function() {
	    document.getElementById("membership-forms").style.visibility = "visible";
	    $.ajax({
	        type: "GET",
	        url: "/api/membership/all",
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
	    if (document.getElementById("membership-dropdown-btn").selectedIndex > 0) {
	        var user, membership;
	        var membershipName = document.getElementById("membership-dropdown-btn").options[document.getElementById("membership-dropdown-btn").selectedIndex].text;
            $.ajax({
                type: "GET",
                url: "/api/user/username",
                data: JSON.stringify({username: username}),
                dataType: "json",
                success: function (u) {
                    user = u;
                }
            });
            $.ajax({
                type: "GET",
                url: "/api/membership/name",
                data: JSON.stringify({name: membershipName}),
                dataType: "json",
                success: function (m) {
                     membership = m;
                }
            });
            $.ajax({
                type: "POST",
                url: "/api/user/membership",
                data: JSON.stringify({user: user, membership: membership}),
                dataType: 'json',
                success: function () {
                    document.getElementById("membership-forms").style.visibility = "hidden";
                }
            });
        }
	});
	document.getElementById("new-membership-btn").addEventListener('click', function() {
	    var user, membership;
	    let membershipName = document.getElementById("new-membership-txt").value;
	    $.ajax({
	        type: "POST",
	        url: "/api/membership/new",
	        cache: false,
	        data: membershipName,
	        success: function (m) {
	            membership = m;
	        }
	    });
	    /*$.ajax({
            type: "GET",
            url: "/api/user/username",
            data: JSON.stringify({username: username}),
            dataType: "json",
            success: function (u) {
                user = u;
            }
        });
        $.ajax({
            type: "POST",
            url: "/api/user/membership",
            data: JSON.stringify({user: user, membership: membership}),
            dataType: 'json',
            success: function () {
                document.getElementById("membership-forms").style.visibility = "hidden";
            }
        });*/
	});
});