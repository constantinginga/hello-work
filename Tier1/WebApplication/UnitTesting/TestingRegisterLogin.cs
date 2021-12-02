using System;
using WebApplication.Data.Authentication;
using WebApplication.Models;
using Xunit;
namespace UnitTesting
{
    public class TestingRegisterLogin
    {
        [Fact]
        public void Register()
        {
            var UserCervice = new UserService();
            var Employer = new Employer();
            Employer.Address = "Horsens";
            Employer.CompanyName = "Company";
            Employer.Email = "UnitTesting@gmail.com";
            Employer.Role = "Employer";
            Employer.PhoneNumber = "89562356";
            Employer.Password = "password";
            UserCervice.CreateEmployer(Employer);
            UserCervice.ValidateUser(Employer.Email, Employer.Password);
        }
    }
}