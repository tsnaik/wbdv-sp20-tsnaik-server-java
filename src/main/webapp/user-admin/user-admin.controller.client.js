(function () {
    let userService = new UserService();
    let rowTemplate;
    let tbody;
    let $createUserBtn;
    let $deleteUserBtn;

    jQuery(main);

    function main() {
        rowTemplate = jQuery('.wbdv-template');
        $createUserBtn = jQuery('.wbdv-create');
        $deleteUserBtn = jQuery('.wbdv-delete');
        tbody = jQuery('tbody');

        $createUserBtn.click(createUser);
        $deleteUserBtn.click(function () {
            console.log('del')
        });
        // $deleteUserBtn.click(deleteUser);

        userService
            .findAllUsers()
            .then(renderUsers);
    }
    function deleteUser() {
        console.log('here');
    }
    function createUser() {
        let $usernameFld = $('#usernameFld');
        let $passwordFld = $('#passwordFld');
        let $firstNameFld = $('#firstNameFld');
        let $lastNameFld = $('#lastNameFld');
        let $roleFld = $('#roleFld option:selected');

        let username = $usernameFld.val();
        let password = $passwordFld.val();
        let firstName = $firstNameFld.val();
        let lastName = $lastNameFld.val();
        let role = $roleFld.val();
        let user = {
            username: username,
            password: password,
            firstName: firstName,
            lastName: lastName,
            role: role
        };

        userService
            .createUser(user)
            .then(userService.findAllUsers)
            .then(renderUsers)
            .then(clearFields);

    }

    function renderUsers(users) {
        console.log(users);
        tbody.empty();
        for (let u in users) {
            const user = users[u];
            const rowClone = rowTemplate.clone();
            rowClone.removeClass('wbdv-hidden');
            rowClone.find('.wbdv-username').html(user.username);
            rowClone.find('.wbdv-first-name').html(user.firstName);
            rowClone.find('.wbdv-last-name').html(user.lastName);
            rowClone.find('.wbdv-role').html(user.role);
            tbody.append(rowClone);
        }
    }

    function clearFields() {
        let $usernameFld = $('#usernameFld');
        let $passwordFld = $('#passwordFld');
        let $firstNameFld = $('#firstNameFld');
        let $lastNameFld = $('#lastNameFld');
        let $roleFld = $('#roleFld');

        $usernameFld.val('');
        $passwordFld.val('');
        $firstNameFld.val('');
        $lastNameFld.val('');
        $roleFld.val('faculty');
    }
})();