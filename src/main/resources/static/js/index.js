document.addEventListener('DOMContentLoaded', function() {
    let username = document.getElementById("username").innerHTML;
    document.getElementById("view-memberships-btn").addEventListener('click', function() {
        let template = document.getElementById("view-memberships-template");
        setTemplateContainer(template.content.cloneNode(true));
        $.ajax({
            type: "GET",
            url: "/api/membership/user?username=" + username,
            dataType: "json",
            success: function (response) {
                let items = '<ul id="membership-list" class="list-group">';
                for (let i = 0; i < response.length; i++) {
                    items += '<li class="list-group-item">' + response[i].name + '</li>';
                }
                items += '</ul>';
                $("#view-memberships").html(items);
            }
        });
    });
	document.getElementById("add-membership-btn").addEventListener('click', function() {
	    let template = document.getElementById("add-membership-template");
	    setTemplateContainer(template.content.cloneNode(true));
	    $.ajax({
	        type: "GET",
	        url: "/api/membership/notuser?username=" + username,
	        dataType: "json",
            success: function (response) {
                let options = '<option value="1">Select a membership</option>';
                for (let i = 0; i < response.length; i++) {
                    options += '<option value="' + response[i].id + '">' + response[i].name + '</option>';
                }
                $("#memberships-dropdown").html(options);
                document.getElementById("membership-dropdown-btn").addEventListener('click', function() {
                    if (document.getElementById("memberships-dropdown").selectedIndex != "0") {
                	    var user, membership;
                        var membershipName = document.getElementById("memberships-dropdown").options[document.getElementById("memberships-dropdown").selectedIndex].text;
                        $.ajax({
                            type: "GET",
                            url: "/api/user/username?username=" + username,
                            async: false,
                            success: function (result) {
                                user = result;
                                $.ajax({
                                    type: "GET",
                                    url: "/api/membership/name?name=" + membershipName,
                                    async: false,
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
                                            data: JSON.stringify(postData)
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
                	if (membershipName !== "") {
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
                                    data: JSON.stringify(postData)
                                });
                            }
                        });
                    }
                });
            }
	    });
	});

	document.getElementById("add-product-btn").addEventListener('click', function() {
    	let template = document.getElementById("add-product-template");
        setTemplateContainer(template.content.cloneNode(true));
	    document.getElementById("new-product-btn").addEventListener('click', function() {
	        if (document.getElementById("new-product-txt").value != "") {
	        let postData = { productName: document.getElementById("new-product-txt").value };
	            $.ajax({
	                type: "POST",
	                url: "/api/product/new",
	                contentType : "application/json",
	                data: JSON.stringify(postData),
                    cache: false,
                    async: false
	            });
	        }
	    });
	});

	document.getElementById("post-perk-btn").addEventListener('click', function() {
	    var limitationArray = [];
	    let template = document.getElementById("post-perk-template");
        setTemplateContainer(template.content.cloneNode(true));
        $.ajax({
            type: "GET",
            url: "/api/membership/all",
            dataType: "json",
            success: function (response) {
                let options = '<option value="1">Select a membership</option>';
                for (let i = 0; i < response.length; i++) {
                    options += '<option value="' + response[i].id + '">' + response[i].name + '</option>';
                }
                $("#perk-membership-dropdown").html(options);
                $.ajax({
                    type: "GET",
                    url: "/api/product/all",
                    dataType: "json",
                    success: function (response) {
                        let options = '<option value="1">Select a product</option>';
                        for (let i = 0; i < response.length; i++) {
                            options += '<option value="' + response[i].id + '">' + response[i].name + '</option>';
                        }
                        $("#perk-product-dropdown").html(options);
                        document.getElementById("limitation-btn").addEventListener('click', function () {
                           if(document.getElementById("registration-settings").style.visibility != 'visible') {
                               document.getElementById("registration-settings").style.visibility = "visible";
                           }
                           else {
                               document.getElementById("registration-settings").style.visibility = "hidden";
                           }
                           document.getElementById("add-limitation-btn").addEventListener("click", function () {
                               if (document.getElementById("limitation-description-txt").value != "") {
                                   let limitationType = document.getElementById("limitation-type-select").options[document.getElementById("limitation-type-select").selectedIndex].text;
                                   let limitationDescription = document.getElementById("limitation-description-txt").value;
                                   let permittedRule = document.getElementsByName("limitationRadios")[0].checked;
                                   let object = {
                                       type: limitationType,
                                       description: limitationDescription,
                                       permitted: permittedRule
                                   };
                                   limitationArray.push(object);
                                   document.getElementById("limitation-description-txt").value = "";
                               }
                           });
                        });
                    }
                })
            }
        })
        document.getElementById("add-perk-btn").addEventListener('click', function() {
            var membership, product;
            let membershipName = document.getElementById("perk-membership-dropdown").options[document.getElementById("perk-membership-dropdown").selectedIndex].text;
            $.ajax({
                type: "GET",
                url: "/api/membership/name?name=" + membershipName,
                cache: false,
                async: false,
                success (result) {
                    membership = result;
                    let productName = document.getElementById("perk-product-dropdown").options[document.getElementById("perk-product-dropdown").selectedIndex].text;
                    $.ajax({
                        type: "GET",
                        url: "/api/product/name?name=" + productName,
                        cache: false,
                        async: false,
                        success (result) {
                            product = result;
                            let perk = document.getElementById("new-perk-txt").value;
                            let expiryDate = document.getElementById("expiry-date").value;
                            let postData = {
                                membershipObj: membership,
                                productObj: product,
                                description: perk,
                                expiryDate: expiryDate,
                                limitations: limitationArray
                            };
                            $.ajax({
                                type: "POST",
                                url: "/api/perk/new",
                                contentType : "application/json",
                                cache: false,
                                async: false,
                                data: JSON.stringify(postData)
                            });
                        }
                    });
                }
            })
        });
	});
});

function setTemplateContainer(element) {
    let parent = document.getElementById("template-container");
    while (parent.firstChild) {
        parent.removeChild(parent.firstChild);
    }
	document.getElementById("template-container").appendChild(element);
}