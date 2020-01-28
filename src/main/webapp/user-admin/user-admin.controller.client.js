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

        findAllUsers();
    };

    let deleteUser = (id) => {
        userService.deleteUser(id)
            .then(findAllUsers);
    };

    let findAllUsers = () =>
        userService
            .findAllUsers()
            .then(renderUsers);

    let findUserById = (id) => {
        userService
            .findUserById(id)
            .then(selectUser);
    };

    let selectUser = (user) => {
        let $usernameFld = $('#usernameFld');
        let $passwordFld = $('#passwordFld');
        let $firstNameFld = $('#firstNameFld');
        let $lastNameFld = $('#lastNameFld');
        let $roleFld = $('#roleFld');

        $usernameFld.val(user.username);
        $passwordFld.val('');
        $firstNameFld.val(user.firstName);
        $lastNameFld.val(user.lastName);
        $roleFld.val(user.role);

        $('.wbdv-create').addClass('wbdv-hidden');
        let $updateBtn = $('.wbdv-update');
        $updateBtn.removeClass('wbdv-hidden');
        $updateBtn.off('click'); // removing previous click handler
        $updateBtn.click(() => {
            updateUser(user._id);
        });
    };

    let updateUser = (id) => {
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
            firstName: firstName,
            lastName: lastName,
            role: role
        };
        if ($.trim(password) !== '') {
            user.password = password;
        }
        delete user['_id'];
        userService.updateUser(id, user)
            .then(findAllUsers)
            .then(clearFields)
            .then(() =>{
                $('.wbdv-create').removeClass('wbdv-hidden');
                $('.wbdv-update').addClass('wbdv-hidden');
            });
    };

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

        rowClone.find('.wbdv-remove').click(function () {
            deleteUser(user._id);
        });
        rowClone.find('.wbdv-edit').click(function () {
            findUserById(user._id);
        });
    };

    let renderUsers = (users) => {
        tbody.empty();
        for (let u in users) {
            renderUser(users[u]);
        }
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