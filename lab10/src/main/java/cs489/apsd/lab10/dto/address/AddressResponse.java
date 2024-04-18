package cs489.apsd.lab10.dto.address;

public record AddressResponse(
        Integer addressId,
        String street,
        String city,
        String state,
        String postalcode,
        String country
) {
}
