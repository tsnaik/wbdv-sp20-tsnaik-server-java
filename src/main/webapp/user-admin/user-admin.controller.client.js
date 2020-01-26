(function () {
    let userService = new UserService();
    let rowTemplate;
    let tbody;
    let $createUserBtn;

    let main = () => {
        rowTemplate = $('.wbdv-template');
        $createUserBtn = $('.wbdv-create');

        tbody = $('tbody');

        $createUserBtn.click(createUser);

        // $deleteUserBtn.click(deleteUser);

        findAllUsers()
            .then(renderUsers);
    };

    let deleteUser = (id) => {
        console.log();

        userService.deleteUser(id)
            .then(findAllUsers).then(renderUsers);
    };

    let findAllUsers = () =>
        userService
            .findAllUsers();

    let createUser = () => {
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
            .then(renderUser)
            .then(clearFields);
    };

    let renderUser = (user) => {
        const rowClone = rowTemplate.clone();
        rowClone.removeClass('wbdv-hidden');
        rowClone.find('.wbdv-username').html(user.username);
        rowClone.find('.wbdv-first-name').html(user.firstName);
        rowClone.find('.wbdv-last-name').html(user.lastName);
        rowClone.find('.wbdv-role').html(user.role);
        rowClone.prop('id', user._id);
        tbody.prepend(rowClone);

        rowClone.find('.wbdv-delete').click(function () {
            // console.log($(this).closest('tr').attr('id'))
            deleteUser($(this).closest('tr').attr('id'));
        });
    };

    let renderUsers = (users) => {
        console.log(users);
        tbody.empty();
        for (let u in users) {
            renderUser(users[u]);
        }

        // $deleteUserBtn.click(function (event) {
        //     console.log('del', $(this).closest('tr').attr('id'));
        // });
    };

    let clearFields = () => {
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
    };
    $(main);
})();