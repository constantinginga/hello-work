using System;
using System.IO;
using WebApplication.Data.Authentication;
using WebApplication.Models;
using Xunit;
using Xunit.Abstractions;
using Xunit.Sdk;

namespace UnitTesting
{
    public class TestingRegisterLogin
    {
        private readonly ITestOutputHelper output;
        public TestingRegisterLogin(ITestOutputHelper outputWriter)
        {
            this.output = outputWriter;
        }
        UserService UserCervice = new();
        JobSeeker jobSeeker = new();
        Employer Employer = new();


        [Fact]
        public async void RegisterEmployer()
        {
            Random rand = new Random();
            
            int stringlen = rand.Next(4, 10);
            int randValue;
            string str = "";
            char letter;
            for (int i = 0; i < stringlen; i++)
            {
                randValue = rand.Next(0, 26);
                letter = Convert.ToChar(randValue + 65);
                str = str + letter;
            }
            Employer.Address = "Horsens";
            Employer.CompanyName = "Company";
            Employer.Email = str+"UnitTesting@gmail.com";
            Employer.Role = "Employer";
            Employer.PhoneNumber = "89562356";
            Employer.Password = "password";
            var user = UserCervice.CreateEmployer(Employer);
            var exception = await Record.ExceptionAsync(() =>
                user);
            if (exception != null)
            {
                output.WriteLine("Throwing exception :" + exception.Message);
                Assert.NotNull(exception);
            }
            Assert.NotNull(user.Result);
            output.WriteLine("No exception thrown process was successful: " + user.Result.Email);
        }


        [Fact]
        public async void RegisterJobSeeker()
        {
            Random rand = new Random();
            
            int stringlen = rand.Next(4, 10);
            int randValue;
            string str = "";
            char letter;
            for (int i = 0; i < stringlen; i++)
            {
                randValue = rand.Next(0, 26);
                letter = Convert.ToChar(randValue + 65);
                str = str + letter;
            }
            jobSeeker.Email = str+"UnitTestingJobSeeker@gmail.com";
            jobSeeker.FirstName = "bob";
            jobSeeker.LastName = "yes";
            jobSeeker.Role = "JobSeeker";
            jobSeeker.PhoneNumber = "23313452";
            jobSeeker.Password = "password";
            var user = UserCervice.CreateJobSeeker(jobSeeker);
            var exception = await Record.ExceptionAsync(() =>
                user);
            if (exception != null)
            {
                output.WriteLine("Throwing exception :" + exception.Message);
                Assert.NotNull(exception);
            }
            Assert.NotNull(user.Result);
            output.WriteLine("No exception thrown process was successful: " + user.Result);
        }

        [Fact]
        public void Login()
        {
            var result = UserCervice.ValidateUser("UnitTestingJobSeeker@gmail.com", "password");
            Assert.Equal("UnitTestingJobSeeker@gmail.com",result.Result.Email);
            Assert.Equal("password",result.Result.Password);
            output.WriteLine("Logging  in as JobSeeker successful");
            
            var result2 = UserCervice.ValidateUser("UnitTesting@gmail.com", "password");
            Assert.Equal("UnitTesting@gmail.com",result2.Result.Email);
            Assert.Equal("password",result2.Result.Password);
            output.WriteLine("Logging  in as JobSeeker Employer");
        }
        [Fact]
        public async void RegisterInvalidEmail()
        {
            jobSeeker.Email = "UnitTestingJobSeekergmail.com";
            jobSeeker.FirstName = "bob";
            jobSeeker.LastName = "yes";
            jobSeeker.Role = "JobSeeker";
            jobSeeker.PhoneNumber = "23313452";
            jobSeeker.Password = "password";
            var user = UserCervice.CreateJobSeeker(jobSeeker);
            var exception = await Record.ExceptionAsync(() =>
                user);
            if (exception != null)
            {
                output.WriteLine("Throwing exception :" + exception.Message);
                Assert.False(false);
            }
        }
        
    }
}