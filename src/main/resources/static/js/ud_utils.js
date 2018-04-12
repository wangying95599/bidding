function setModalData(modal, mapper, data) {
    Object.keys(mapper).forEach(function (key) {
        const value = mapper[key];
        if (data) {
            if (typeof(value) === 'string') {
                modal.find('#' + key).val(data[value]);
            } else {
                if (value.isCheckbox) {
                }
            }
        } else {
            if (typeof(value) === 'string') {
                modal.find('#' + key).val(null);
            } else {
                if (value.isCheckbox) {
                    modal.find('input[name=' + key + ']').attr('checked', false);
                }
            }
        }
    });
}

function isArray(o) {
    return Object.prototype.toString.call(o) == '[object Array]';
}

