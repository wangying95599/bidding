function setModalData(modal, mapper, data) {
    Object.keys(mapper).forEach(function (key) {
        const value = mapper[key];
        if (data) {
            if (typeof(value) === 'string') {
                modal.find('#' + key).val(data[value]);
            } else {
                if (value.isCheckbox) {
                    const regionsFromService = data[value.name];
                    if (value.name === 'regionList') {
                        if (regionsFromService) {
                            //（jquery1.9以上，checkbox attr不能重复操作）可使用prop代替
                            modal.find('input[name=' + key + ']').attr('checked', false);
                            $.each(regionsFromService, function (i, item) {
                                $("input[name='set_region'][value=" + item.region + "]").prop("checked", "checked");
                            });
                        }
                    }
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

