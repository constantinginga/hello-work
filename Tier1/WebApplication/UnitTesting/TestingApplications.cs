using System;
using System.Collections.Generic;
using System.Linq;
using WebApplication;
using WebApplication.Data;
using WebApplication.Data.Applications;
using WebApplication.Data.Authentication;
using WebApplication.Models;
using Xunit;
using Xunit.Abstractions;

namespace UnitTesting
{
    public class TestingApplications
    {
        private readonly ITestOutputHelper output;
        public TestingApplications(ITestOutputHelper outputWriter)
        {
            output = outputWriter;
        }
        Application application = new(); 
        ApplicationData ApplicationData = new();
        JobListingData JobListingData = new();
        
        [Fact]
        public async void CreatingApplication()
        {
            var listing = JobListingData.GetJobListings().Result.First();
            application.Details = "Testing application";
            application.employerEmail = "UnitTestCreatingApplication@gmail.com";
            application.employeEmail = "UnitTestCreatingApplication@gmail.com";
            application.Files = new List<string>();
            application.Name = "UnitTestCreatingApplication";
            application.JobId = listing.JobId;
            application.Status = 0;
            application.Id = new Random().Next();
            var newapplication =  ApplicationData.AddApplication(application);
            var exception = await Record.ExceptionAsync(() =>
                newapplication);
            
            if (exception != null)
            {
                output.WriteLine("Throwing exception:" + exception.Message);
                Assert.IsType<Exception>(exception);
                
            }
            if (exception == null)
            {
                output.WriteLine("No exception thrown application was created");
            }
            
        }
    }
}